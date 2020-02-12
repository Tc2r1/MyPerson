package com.ideal.partner.controllers;

import com.ideal.partner.domain.Partner;
import com.ideal.partner.services.PartnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by tc2r on 02/11/20.
 */
@RequestMapping("/partner")
@Controller
public class PartnerController
{

    private PartnerService partnerService;

    @Autowired
    public void setPartnerService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }


    @RequestMapping({"/list", "/"})
    public String listPartners(Model model){
        model.addAttribute("partners", partnerService.listAll());
        return "partner/list";
    }

    @RequestMapping("/show/{id}")
    public String showPartner(@PathVariable Integer id, Model model){
        model.addAttribute("partner", partnerService.getById(id));
        return "partner/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("partner", partnerService.getById(id));
        return "partner/partnerform";
    }

    @RequestMapping("/new")
    public String newPartner(Model model){
        model.addAttribute("partner", new Partner());
        return "partner/partnerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Partner partner){
        Partner newPartner = partnerService.saveOrUpdate(partner);
        return "redirect:partner/show/" + newPartner.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        partnerService.delete(id);
        return "redirect:/partner/list";
    }
}
