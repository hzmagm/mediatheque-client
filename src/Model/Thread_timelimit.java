/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HP
 */
public class Thread_timelimit extends Thread{
    @Override
    public void run(){


        try{
            this.sleep(10800000);
        }catch(InterruptedException inte){

        }

        System.exit(0);

    }

}