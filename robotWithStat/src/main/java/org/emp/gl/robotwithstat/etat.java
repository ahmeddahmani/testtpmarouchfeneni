/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.robotwithstat;

/**
 *
 * @author fnmb4
 */
public abstract class etat {

    /**
     *
     */
    protected abstract void turnR();
   protected abstract void turnL();
    protected abstract void turnU();
     protected abstract void turnD();
    protected rebot rb = null;
    private etat(){};
    public etat(rebot a)
    {
        rb=a;
    }
}
