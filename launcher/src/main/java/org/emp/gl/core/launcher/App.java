package org.emp.gl.core.launcher;


import java.util.Map;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.environement.MapLaby;
import org.emp.gl.labydisplay.Laby;
import org.emp.gl.robotwithstat.rebot;
import org.emp.gl.time.control.GuiControl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;
/**
 * Hello world!
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
        //Lookup.getInstance().register(TimerService.class,new TimerServiceImplWithDelegation() );
    }

    public static void main(String[] args) {

       // testDuTimeService();
       launchApp();
       
    }

    //part 2
    private static void launchApp()
    {
        //Lookup.getInstance().getService(TimerService.class
        TimerServiceImplWithDelegation ts = new TimerServiceImplWithDelegation();
        rebot rb = new rebot();
        MapLaby ml = new MapLaby();
        rb.addListener(ml);
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiControl().setVisible(true);
                Laby notreLab = new Laby();
                ml.addListener(notreLab);
                notreLab.setVisible(true);
            }
        });
                 
         
        
    }
}
