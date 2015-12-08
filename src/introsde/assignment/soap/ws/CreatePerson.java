
package introsde.assignment.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person" type="{http://ws.soap.assignment.introsde/}person" minOccurs="0"/>
 *         &lt;element name="healthp" type="{http://ws.soap.assignment.introsde/}helthprofile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPerson", propOrder = {
    "person",
    "healthp"
})
public class CreatePerson {

    protected Person person;
    protected Helthprofile healthp;

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the healthp property.
     * 
     * @return
     *     possible object is
     *     {@link Helthprofile }
     *     
     */
    public Helthprofile getHealthp() {
        return healthp;
    }

    /**
     * Sets the value of the healthp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Helthprofile }
     *     
     */
    public void setHealthp(Helthprofile value) {
        this.healthp = value;
    }

}
