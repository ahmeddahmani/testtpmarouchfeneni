/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timerservice.TimeService;

/**
 *
 * @author ahmed
 */
public class TimerServiceImplWithDelegation extends TimerTask implements TimeService {
    int secondes;
    int dixiemeDeSeconde;
    
    private PropertyChangeSupport PCS=null ;
    private PropertyChangeEvent pce=null ;

    /**
     * Constructeur du DummyTimeServiceImpl Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de
     * réaliser des tocs à chaque N millisecondes
     */
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();
        this.PCS =new PropertyChangeSupport(this);
        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();

        timer.scheduleAtFixedRate(this, 100, 100);
        Lookup.getInstance().register(TimeService.class, this);
    }

    @Override
    public void run() {
        timeChanged();
    }

    

    @Override
    public void addTimeChangeListener(PropertyChangeListener pl) {
        PCS.addPropertyChangeListener(pl);
    }

   @Override
    public void removeTimeChangeListener(PropertyChangeListener pl) {
        PCS.removePropertyChangeListener(pl);
    }

     private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;
        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    protected void updateSecode() {
       pce=new PropertyChangeEvent(this,"seconde",
                    null, 1);
       PCS.firePropertyChange(pce);
            
    }

    
   
   

}
   
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */








