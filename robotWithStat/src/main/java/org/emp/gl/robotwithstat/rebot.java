/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.robotwithstat;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.emp.gl.changeetatinterface.changeOrientation;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timerservice.TimeService;


/**
 *
 * @author fnmb4
 */
public class rebot implements changeOrientation , PropertyChangeListener 
{
    
    private  PropertyChangeSupport  pcs=null;
    int x=5;
    int y=5;
    private ArrayList<Integer> cordenates =null;
    private int orientation=2;
    private etat rebotEtat=new toLeft(this);
    private boolean[][] labyrinthe = {
         {false, false, false, false, false, false, false, false, false, false},
         {false, true, true, true, false, true, true, true, true, true},
         {true, true, false, true, false, true, false, false, false, false},
         {false, false, false, true, false, true, true, true, true, false},
         {false, true, true, true, true, false, false, false, true, false},
         {false, false, false, false, true, false, true, false, true, false},
         {false, true, true, false, true, false, true, false, true, false},
         {false, false, true, false, true, false, true, false, true, false},
         {false, true, true, true, true, true, true, true, true, false},
         {false, false, false, false, false, false, true, false, false, false},
        };
   public rebot(){pcs=new PropertyChangeSupport(this);
   Lookup.getInstance().register(changeOrientation.class,this);
   Lookup.getInstance().getService(TimeService.class).addTimeChangeListener(this);
   };
   
   
   public void addListener(PropertyChangeListener L)
   {
       pcs.addPropertyChangeListener(L);
   }
   
   
   @Override
    public void tournerGauche() {
        rebotEtat.turnL();
    }

    @Override
    public void tournerDroite() {
       rebotEtat.turnR();
    }
   
    public void setStat(etat a)
    {
        this.rebotEtat=a;
    }
   public void setOrientation(int a)
   {
       orientation=a;
   }
   public int getOrientation()
   {
       return orientation;
   }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("seconde"))
                {
                    if(orientation==0&&x<9&&this.labyrinthe[y][x+1])
                        x++;
                    if(orientation==1&&y>0&&this.labyrinthe[y-1][x])
                        y--;
                    if(orientation==2&&x>0&&this.labyrinthe[y][x-1])
                        x--;
                    if(orientation==3&&y<9&&this.labyrinthe[y+1][x])
                        y++;
                    cordenates= new ArrayList<>();
                    cordenates.add(x);
                    cordenates.add(y);
                    pcs.firePropertyChange("position",orientation,cordenates);
                    
                }
    }

    @Override
    public void tournerBas() {
        rebotEtat.turnD();
    }

    @Override
    public void tournerHaut() {
        rebotEtat.turnU();
    }
    
}
