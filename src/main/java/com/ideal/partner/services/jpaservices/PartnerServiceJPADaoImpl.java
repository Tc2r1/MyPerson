package com.ideal.partner.services.jpaservices;

import com.ideal.partner.domain.Partner;
import com.ideal.partner.services.PartnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Created by tc2r on 02/11/2020.
 */
@Service
@Profile("jpadao")
public class PartnerServiceJPADaoImpl extends AbstractJpaDaoService implements PartnerService
{

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Partner> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Partner", Partner.class).getResultList();
    }

    @Override
    public Partner getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Partner.class, id);
    }

    @Override
    public Partner saveOrUpdate(Partner domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(
                    encryptionService.encryptString(domainObject.getUser().getPassword()));
        }

        Partner savedPartner = em.merge(domainObject);
        em.getTransaction().commit();

        return savedPartner;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Partner.class, id));
        em.getTransaction().commit();
    }
}
