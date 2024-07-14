package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Batt;
import com.example.demo.service.BatServ;

@RestController
@RequestMapping("/batteries")
public class BatCont {
    @Autowired
    private BatServ batServ;

    @PostMapping
    public List<Batt> addBatteries(@RequestBody List<Batt> batteries) {
        return batteries.stream().map(batServ::saveBattery).collect(Collectors.toList());
    }

    @GetMapping
    public BatteryStats getBatteriesInRange(@RequestParam String startPostcode, @RequestParam String endPostcode) {
        List<Batt> batteries = batServ.getBatteriesByPostcodeRange(startPostcode, endPostcode);
        batteries.sort(Comparator.comparing(Batt::getName));
        int totalWattCapacity = batteries.stream().mapToInt(Batt::getWattCapacity).sum();
        double averageWattCapacity = batteries.isEmpty() ? 0 : (double) totalWattCapacity / batteries.size();
        List<String> names = batteries.stream().map(Batt::getName).collect(Collectors.toList());

        return new BatteryStats(names, totalWattCapacity, averageWattCapacity);
    }

    public static class BatteryStats {
        private List<String> names;
        private int totalWattCapacity;
        private double averageWattCapacity;

        public BatteryStats(List<String> names, int totalWattCapacity, double averageWattCapacity) {
            this.names = names;
            this.totalWattCapacity = totalWattCapacity;
            this.averageWattCapacity = averageWattCapacity;
        }

		public List<String> getNames() {
			return names;
		}

		public void setNames(List<String> names) {
			this.names = names;
		}

		public int getTotalWattCapacity() {
			return totalWattCapacity;
		}

		public void setTotalWattCapacity(int totalWattCapacity) {
			this.totalWattCapacity = totalWattCapacity;
		}

		public double getAverageWattCapacity() {
			return averageWattCapacity;
		}

		public void setAverageWattCapacity(double averageWattCapacity) {
			this.averageWattCapacity = averageWattCapacity;
		}



    }
}
