package generatedata.DataFactory.impl;

import generatedata.DataFactory.*;
import org.jfairy.Fairy;
import org.jfairy.producer.company.Company;
import org.jfairy.producer.person.Person;
import warehouse.classes.Item;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Created by pawelwiejkut on 13.03.2016.
 */
public final class DataFactExt extends DataFactory {

    private ProjectDataValues projectDataValues = new DefaultProjectDataValues();
    private EmployeeDataValues employeeDataValues = new DefaultEmployeeDataValue();
    private DepartmentDataValues departmentDataValues = new DefaultDepartmentDataValues();
    private ItemDataValues itemDataValues = new DefaultItemValues();
    private PlaceDataValues placeDataValues = new DefaultPlaceData();


    public String getItemName(){return  getItem(itemDataValues.getItemName());}
    public String getProjectName() {
        return getItem(projectDataValues.getProjectName());
    }
    public String getPlaceName(){return getItem(placeDataValues.getPlaceName());}

    public String getProjectSubject() {
        return getItem(projectDataValues.getProjectSubject());
    }

    public String getEmployeeJob(){
        return getItem(employeeDataValues.getEmployeeJob());
    }

    public String getEmployeeName(){
        Fairy plFairy = Fairy.create(Locale.forLanguageTag("pl"));
        Person person = plFairy.person();
        return person.fullName();
    }

    public Date getEmployeeHireDate(){
        return getBirthDate();
    }

    public double getEmployeeSalary(){
        Random r = new Random();
        long salary;
        salary = Math.round(2000 + (5000 - 1000) * r.nextDouble());
        return (double)salary;
    }

    public String getDepartmentName(){
        return getItem(departmentDataValues.getDepartmentName());
    }

    public String getDepartmentLocation(){
        Fairy plFairy = Fairy.create(Locale.forLanguageTag("pl"));
        Person person = plFairy.person();
        return person.getAddress().toString().replaceAll("\\d","").replaceAll("-","").trim();
    }

    public String getCompanyName(){
        Fairy plFairy = Fairy.create(Locale.forLanguageTag("pl"));
        Company company = plFairy.company();
        return company.name();
    }

}
