/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsde.assignment.soap.ws;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benhur
 */
@XmlRootElement(name="measureType")
public class MeasureType_1 {

  private List<MeasureTyp> measure;

  public void setMeasure(List<MeasureTyp> measure) {
    this.measure = measure;
  }

  public List<MeasureTyp> getMeasure() {
    return measure;
  }

} 