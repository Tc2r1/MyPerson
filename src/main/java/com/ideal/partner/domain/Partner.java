package com.ideal.partner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Partner implements DomainObject
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Version
  private Integer version;

  private String sex;
  private String ethnicity;
  private String build;
  private int height;
  private String religion;
  private String occupation;
  private String educationLevel;
  private int ageMin;
  private int ageMax;



  @Override
  public Integer getId()
  {
    return id;
  }

  @Override
  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getVersion()
  {

    return version;
  }

  public void setVersion(Integer version)
  {

    this.version = version;
  }

  public String getSex()
  {

    return sex;
  }

  public void setSex(String sex)
  {

    this.sex = sex;
  }

  public String getEthnicity()
  {

    return ethnicity;
  }

  public void setEthnicity(String ethnicity)
  {

    this.ethnicity = ethnicity;
  }

  public String getBuild()
  {

    return build;
  }

  public void setBuild(String build)
  {

    this.build = build;
  }

  public int getHeight()
  {

    return height;
  }

  public void setHeight(int height)
  {

    this.height = height;
  }

  public String getReligion()
  {

    return religion;
  }

  public void setReligion(String religion)
  {

    this.religion = religion;
  }

  public String getOccupation()
  {

    return occupation;
  }

  public void setOccupation(String occupation)
  {

    this.occupation = occupation;
  }

  public String getEducationLevel()
  {

    return educationLevel;
  }

  public void setEducationLevel(String educationLevel)
  {

    this.educationLevel = educationLevel;
  }

  public int getAgeMin()
  {

    return ageMin;
  }

  public void setAgeMin(int ageMin)
  {

    this.ageMin = ageMin;
  }

  public int getAgeMax()
  {

    return ageMax;
  }

  public void setAgeMax(int ageMax)
  {

    this.ageMax = ageMax;
  }
}
