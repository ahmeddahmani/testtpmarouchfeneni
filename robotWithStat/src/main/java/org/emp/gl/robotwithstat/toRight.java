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
public class toRight extends etat
{

    public toRight(rebot a) {
        super(a);
    }

    @Override
    protected void turnR() {

    }

    @Override
    protected void turnL() {
      
    }

    @Override
    protected void turnU() {
rb.setOrientation(1);
       rb.setStat(new toUp(rb)); 
               System.out.println(rb.getOrientation());

    }

    @Override
    protected void turnD() {
rb.setOrientation(3);
       rb.setStat(new toDown(rb)); 
        System.out.println(rb.getOrientation());
    }
    
}
