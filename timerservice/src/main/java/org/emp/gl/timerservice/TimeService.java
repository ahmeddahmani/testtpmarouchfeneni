/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timerservice;

import java.beans.PropertyChangeListener;

/**
 *
 * @author fnmb4
 */
public interface TimeService {
    public void addTimeChangeListener(PropertyChangeListener pcl);
    public void removeTimeChangeListener(PropertyChangeListener pcl);    
    
    
}
