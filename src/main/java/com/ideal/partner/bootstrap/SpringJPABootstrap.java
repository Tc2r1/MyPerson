package com.ideal.partner.bootstrap;

import com.ideal.partner.domain.Partner;
import com.ideal.partner.services.PartnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by tc2r on 02/11/2020.
 */
@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    private PartnerService partnerService;

    @Autowired
    public void setPartnerService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        preloadPartners();


    }

    public void preloadPartners(){

        Partner partner1 = new Partner();
        partner1.setAgeMax(40);
        partner1.setAgeMin(20);
        partner1.setBuild("Fat");
        partner1.setEducationLevel("College");
        partner1.setEthnicity("Asian");
        partner1.setHeight("6'2");
        partner1.setOccupation("Homeless");
        partner1.setSex("Female");
        partner1.setReligion("Satanic");
        partnerService.saveOrUpdate(partner1);

      Partner partner2 = new Partner();
      partner2.setAgeMax(25);
      partner2.setAgeMin(18);
      partner2.setBuild("Afthletic");
      partner2.setEducationLevel("diploma");
      partner2.setEthnicity("Irish");
      partner2.setHeight("5'7");
      partner2.setOccupation("Medical");
      partner2.setSex("Female");
      partner2.setReligion("Catholic");
      partnerService.saveOrUpdate(partner2);

      Partner partner3 = new Partner();
      partner3.setAgeMax(32);
      partner3.setAgeMin(25);
      partner3.setBuild("Normal");
      partner3.setEducationLevel("N/A");
      partner3.setEthnicity("All");
      partner3.setHeight("5'9");
      partner3.setOccupation("Lawyer");
      partner3.setSex("Male");
      partner3.setReligion("Muslim");
      partnerService.saveOrUpdate(partner3);

      Partner partner4 = new Partner();
      partner1.setAgeMax(37);
      partner1.setAgeMin(30);
      partner1.setBuild("Slightly Overweight");
      partner1.setEducationLevel("College");
      partner1.setEthnicity("Black");
      partner1.setHeight("5'8");
      partner1.setOccupation("Computer Science");
      partner1.setSex("Female");
      partner1.setReligion("Christian");
      partnerService.saveOrUpdate(partner1);
    }
}
