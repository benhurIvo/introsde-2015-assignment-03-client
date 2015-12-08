/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsde.assignment.soap.client;

/**
 *
 * @author benhur
 */
import introsde.assignment.soap.ws.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PeopleClient {

    static int first_person_id = 0;
    static int last_person_id = 0;
    static int new_person_id = 0;
    static int mid = 0;
    static int new_mid = 0;
    static int count = 0;
    static int newcount = 0;
    static  int i = 0;

    public static void main(String[] args) throws Exception {
	try {

	    PeopleService service = new PeopleService();
	    People pService = service.getPeopleImplPort();

	    //Read person list 
	    //Method #1: readPersonList()
	    System.out.println("Method #1: readPersonList()");
	    System.out.println("Parameters: None.");
	    System.out.println("Description: Reads all the people in our database and save their number\n ");
	    List<Pason> pList = pService.getPeopleList();
	    //if the list of people is empty
	    if (pList != null) {
		count = pList.size();
		//if the list of people has few people
		if (count > 3) {
		    System.out.println("There are " + count + " people in our database");
		    System.out.println("Save Ids of first and last person");
		    first_person_id = Integer.parseInt(pList.get(0).getPersonId());
		    last_person_id = Integer.parseInt(pList.get(pList.size() - 1).getPersonId());
		    System.out.println("------List of people in our database------");

		    for (Pason p2 : pList) {
			i++;
			System.out.println(i+" Person No:" + p2.getPersonId() + " Firstname:" + p2.getFirstname() + " Lastname:" + p2.getLastname() + " Birthdate:" + p2.getBirthdate());
			System.out.println("Healthprofile: Height:" + p2.getHProfile().getWeight() + " Weight:" + p2.getHProfile().getWeight() + " Bloodpressure:" + p2.getHProfile().getBloodpressure() + "\n");
		    }
		    System.out.println("\n************************************************************\n");
		    //Method #2: readPerson(Long id)
		    System.out.println("Method #2: readPerson(Long id)");
		    System.out.println("Parameters: id of person");
		    System.out.println("Description: Prints first person");
		    Pason p = pService.readPerson(first_person_id);
		    System.out.println("\n------First person------");

		    System.out.println("Person No:" + p.getPersonId() + " Firstname:" + p.getFirstname() + " Lastname:" + p.getLastname() + " Birthdate:" + p.getBirthdate());
		    System.out.println("Healthprofile: Height:" + p.getHProfile().getWeight() + " Weight:" + p.getHProfile().getWeight() + " Bloodpressure:" + p.getHProfile().getBloodpressure() + "\n");

		    System.out.println("\n************************************************************\n");

		    //Method #3: updatePerson(Person p)
		    System.out.println("Method #3: updatePerson(Person p)");
		    System.out.println("Parameters: Person object with parameters to update eg first or last name");
		    System.out.println("Description: Updates the first person's name to 'Maurizio'");
		    Person pp = new Person();
		    pp.setFirstname("Maurizio");
		    Pason p3 = pService.updatePerson(pp, first_person_id);
		    System.out.println("Person No:" + p3.getPersonId() + " Firstname:" + p3.getFirstname() + " Lastname:" + p3.getLastname() + " Birthdate:" + p3.getBirthdate());
		    System.out.println("Healthprofile: Height:" + p3.getHProfile().getWeight() + " Weight:" + p3.getHProfile().getWeight() + " Bloodpressure:" + p3.getHProfile().getBloodpressure() + "\n");

		    System.out.println("\n************************************************************\n");

		    //Method #4: createPerson(Person p)
		    System.out.println("Method #4: createPerson(Person p)");
		    System.out.println("Parameters: New person object with first and last name, birthdate and healthprofile");
		    System.out.println("Description: Creates a person with name 'Yoweri' 'Museveni' saves "
			    + "the id of new person and counts the people");
		    Person p4 = new Person();
		    p4.setFirstname("Yoweri");
		    p4.setLastname("Museveni");
		    p4.setBirthdate("18/03/1960");
		    Helthprofile hp = new Helthprofile();
		    hp.setValue("28");
		    hp.setValue("98");
		    Pason psn = pService.createPerson(p4, hp);
		    new_person_id = Integer.parseInt(psn.getPersonId());
		    System.out.println("\n------Person created------");
		    System.out.println("Person No:" + psn.getPersonId() + " Firstname:" + psn.getFirstname() + " Lastname:" + psn.getLastname() + " Birthdate:" + psn.getBirthdate());
		    System.out.println("Healthprofile: Height:" + psn.getHProfile().getWeight() + " Weight:" + psn.getHProfile().getWeight() + " Bloodpressure:" + psn.getHProfile().getBloodpressure() + "\n");

		    System.out.println("\n************************************************************\n");

		    List<Pason> ppnn = pService.getPeopleList();
		    newcount = ppnn.size();
		    System.out.println("************* New people count is " + newcount + " after insertion *************");
		    System.out.println("------New List of people in our database------");
		    i=0;
		    for (Pason p2 : ppnn) {
			i++;
			System.out.println(i+" Person No:" + p2.getPersonId() + " Firstname:" + p2.getFirstname() + " Lastname:" + p2.getLastname() + " Birthdate:" + p2.getBirthdate());
			System.out.println("Healthprofile: Height:" + p2.getHProfile().getWeight() + " Weight:" + p2.getHProfile().getWeight() + " Bloodpressure:" + p2.getHProfile().getBloodpressure() + "\n");
		    }
		    System.out.println("\n************************************************************\n");

		    //Method #5: deletePerson(Long id)
		    System.out.println("Method #5: deletePerson(Long id)");
		    System.out.println("Parameters: id of person to delete");
		    System.out.println("Description: Deletes the newly created person");
		    List<Pason> ppl = pService.deletePerson(new_person_id);
		    newcount = pService.getPeopleList().size();
		    System.out.println("************** New count is " + newcount + " after deleting *************\n");
		    System.out.println("------ List of people in our database after deleting------");
		    i=0;
		    for (Pason p2 : ppl) {
			i++;
			System.out.println(i+" Person No:" + p2.getPersonId() + " Firstname:" + p2.getFirstname() + " Lastname:" + p2.getLastname() + " Birthdate:" + p2.getBirthdate());
			System.out.println("Healthprofile: Height:" + p2.getHProfile().getWeight() + " Weight:" + p2.getHProfile().getWeight() + " Bloodpressure:" + p2.getHProfile().getBloodpressure() + "\n");
		    }

		    System.out.println("\n************************************************************\n");

		    //Method #6: readPersonHistory(Long id, String measureType) 
		    System.out.println("Method #6: readPersonHistory(Long id, String measureType)");
		    System.out.println("Parameters: id of person and measuretype string eg 'height';\n NB: the measuretype should be in our database");
		    System.out.println("Description: Reads height history of last person and saves id of last height measure");
		    List<Measure> ml = pService.readPersonHistory(first_person_id, "height");
		    System.out.println("\nHeight History of first person");
		    for (Measure mm : ml) {
			mid = Integer.parseInt(mm.getTypeId());
			System.out.println("id:" + mm.getTypeId() + " value:" + mm.getValue() + " Datechanged:" + mm.getDatechanged());

		    }
		    System.out.println("\n************************************************************\n");

		    //Method #7: readMeasureTypes()
		    System.out.println("Method #7: readMeasureTypes()");
		    System.out.println("Parameters: None");
		    System.out.println("Description: Reads the Measuretypes in our database");
		    List<MeasureTyp> mt = pService.readMeasureTypes();
		    System.out.println("Measure Types are: \n");
		    for (MeasureTyp mttt : mt) {
			System.out.println(mttt.getValue());
		    }
		    System.out.println("\n************************************************************\n");

		    //Method #8: readPersonMeasure(Long id, String measureType, Long mid) 
		    System.out.println("Method #8: readPersonMeasure(Long id, String measure, Long mid)");
		    System.out.println("Parameters: id of person, measuretype string eg 'weight' and id of measuretype in database");
		    System.out.println("Description: Prints the height of the first person with the measure id we saved in step 6 above");
		    Measure nmm1 = pService.readPersonMeasure(first_person_id, "height", mid);
		    System.out.println("id:" + nmm1.getTypeId() + " value:" + nmm1.getValue() + " Datechanged:" + nmm1.getDatechanged());

		    System.out.println("\n************************************************************\n");

		    //Method #9: savePersonMeasure(Long id, Measure m)
		    System.out.println("Method #9: savePersonMeasure(Long id,String measuretype, Measure m)");
		    System.out.println("Parameters: id of person,measuretype string, object of measuretype with the value");
		    System.out.println("Description: Saves a new height of 20 for the first person, we keep the new measure id");
		    Measure m = new Measure();
		    m.setValue("20");
		    m.setDatechanged(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		    List<Measure> nm = pService.savePersonMeasure(first_person_id, "height", m);
		    new_mid = Integer.parseInt(nm.get(nm.size() - 1).getTypeId());

		    System.out.println("id:" + nm.get(nm.size() - 1).getTypeId() + " value:" + nm.get(nm.size() - 1).getValue() + " Datechanged:" + nm.get(nm.size() - 1).getDatechanged());

		    System.out.println("\n************************************************************\n");

		    //Method #10: updatePersonMeasure(Long id, Measure m)
		    System.out.println("Method #10: updatePersonMeasure(Long id, Measure m, measure_object, measure_id)");
		    System.out.println("Parameters: id of person,measuretype string, object of measuretype with the value and the measure id");
		    System.out.println("Description: Updates the newly created height to 30 using its measure id saved in method 9");
		    Measure mm = new Measure();
		    mm.setValue("30");
		    Measure nmm = pService.updatePersonHealthProfile(first_person_id, "height", mm, new_mid);
		    System.out.println("id:" + nmm.getTypeId() + " value:" + nmm.getValue() + " Datechanged:" + nmm.getDatechanged());

		    System.out.println("\n************************************************************\n");

		} else {
		    System.out.println("Too few values, cant proceed!!");
		}
	    } else {
		System.out.println("No values in the database!!");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

}
