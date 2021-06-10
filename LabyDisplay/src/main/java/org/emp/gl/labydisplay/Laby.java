package org.emp.gl.labydisplay;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JFrame;
import org.emp.gl.core.lookup.Lookup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fnmb4
 */
public class Laby  extends JFrame implements PropertyChangeListener
{
   /**
    * <p>Serial version UID.</p>
    */
   private static final long serialVersionUID = 1L;

   /** La minuterie pour l'affichage des disques. */
   private Timer minuterie;

   /** Le labyrinthe. */
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

   /** Position courante en x dans le labyrinthe. */
   private int x;

   /** Position courante en y dans le labyrinthe. */
   private int y;

   /** Position de départ en x dans le labyrinthe. */
   private final int xd = 0;

   /** Position de départ en y dans le labyrinthe. */
   private final int yd = 2;





/** Taille du pion se déplaçant dans le labyrinthe. */
   private static final int TAILLE_PION = 18;

   /** Taille des cases du labyrinthe. */
   private static final int TAILLE_CASE = 20;

   /** Taille du décalage à gauche du labyrinthe. */
   private static final int DEC_GAUCHE = 25;

   private static final int DEC_HAUT    /** Taille du décalage en haut du labyrinthe. */
= 50;



 public Laby ()
   {
      super("Labyrinthe graphique");

      // Initialisation du labyrinthe.
      this.x = 0;
      this.y = 2;

      // Initialisation du timer.
      

      // Propriétés de la fenêtre.
      setLocation(50, 50);
      setSize(295, 315);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
   }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("guipos"))
        {
            y=((ArrayList<Integer>)evt.getNewValue()).get(1);
            x=((ArrayList<Integer>)evt.getNewValue()).get(0);
        this.repaint();
        }
    }
    public void paint(Graphics g)
   {
      // Parcourt le labyrinthe.
      for(int i = 0; i < this.labyrinthe.length; i++)
      {
         for(int j = 0; j < this.labyrinthe.length; j++)
         {
            // Case libre.
            if(this.labyrinthe[i][j])
            {
               g.setColor(Color.WHITE);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
               g.setColor(Color.LIGHT_GRAY);
               g.drawRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
            // Mur.
            else
            {
               g.setColor(Color.BLUE);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
         }
      }
      g.setColor(Color.red);
      g.fillOval(DEC_GAUCHE+1+this.x*TAILLE_CASE,DEC_HAUT+1+this.y*TAILLE_CASE,TAILLE_PION,TAILLE_PION);
   }
}
