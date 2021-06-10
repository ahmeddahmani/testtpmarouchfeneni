/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author tina
 */
public interface TimerChangeListener  
        extends PropertyChangeListener
{
    final static String SECONDE_PROP = "seconde" ;
    // propertyChange aprés délégation ;
    void propertyChange (PropertyChangeEvent pce) ;
                  
}
