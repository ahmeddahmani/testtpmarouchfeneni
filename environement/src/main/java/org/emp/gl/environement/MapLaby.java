/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.environement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.emp.gl.core.lookup.Lookup;

/**
 *
 * @author fnmb4
 */
public class MapLaby implements PropertyChangeListener {
    private boolean[][] matrice=new boolean [10][10];
   int nbrIntedit;
    private int xRebot;
    private int yRebot;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public MapLaby()
    {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("position")){
        xRebot=((ArrayList<Integer>) evt.getNewValue()).get(0);
        yRebot=((ArrayList<Integer>) evt.getNewValue()).get(1);
        pcs.firePropertyChange("guipos",null,evt.getNewValue());
        String Orientation;
        int or=(int)evt.getOldValue();
        System.out.println("lkqfjlgomqljrfkmqkj!fdk------>>>"+or);
        switch (or) {
            case 0 :
            System.out.println("x="+xRebot+"y="+yRebot);
            System.out.println("orionté à droite");
            break;
            case 1 :
            System.out.println("x="+xRebot+"y="+yRebot);
            System.out.println("orionté haut");
            break;
            case 2 :
            System.out.println("x="+xRebot+"y="+yRebot);
            System.out.println("orionté à gauche");
            break;
            case 3 :
            System.out.println("x="+xRebot+"y="+yRebot);
            System.out.println("orionté bas");
        }
        }
            
        
    }
    
    public void addListener(PropertyChangeListener L)
   {
       pcs.addPropertyChangeListener(L);
   }
}
