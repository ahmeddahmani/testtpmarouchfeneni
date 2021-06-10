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
public class toDown extends etat
{

    public toDown(rebot a) {
        super(a);
    }

    @Override
    protected void turnR() {
        rb.setOrientation(0);
       rb.setStat(new toRight(rb));
    }

    @Override
    protected void turnL() {
        rb.setOrientation(2);
       rb.setStat(new toLeft(rb));
    }

    @Override
    protected void turnU() {
    }

    @Override
    protected void turnD() {
    }
}
