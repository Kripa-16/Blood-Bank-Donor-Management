package com.BloodBank.Donor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BloodBank.Donor.model.BloodGroupModel;
import com.BloodBank.Donor.services.SupplyService;

@Controller
public class SupplyController {
    @Autowired
    private SupplyService supplyService;
    
    @GetMapping("/supply")
    public String DonateNow(Model model) {
    	BloodGroupModel blood = new BloodGroupModel();
    	model.addAttribute("supply", blood);
    	return "supply";
    }

    @PostMapping("/supply")
    public String supplyBlood(@RequestParam String type, @RequestParam int units) {
        supplyService.supplyBlood(type, units);
        return "redirect:/viewBloodStock";
    }
}