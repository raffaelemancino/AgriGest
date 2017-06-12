/* 
 * Copyright (C) 2017 Raffaele Francesco Mancino
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.raffaele.agrigest.controller;

import com.raffaele.agrigest.model.Home_model;
import com.raffaele.agrigest.view.Home_view;
import com.raffaele.agrigest.view.BaseWindow;
import javax.swing.JPanel;

/**
 *
 * @author Raffaele Francesco Mancino
 * 
 */
public class AgriGest_Controller
{
    public int masseriaID;
    
    private BaseWindow baseWindow=new BaseWindow(); //starting window
    
    private Home_model home_model=new Home_model(); //loading model
    private Home_view home_view=new Home_view(this.home_model); //loading view
    
    public AgriGest_Controller()
    {
        
    }
    
    public void init(int id)
    {
        this.baseWindow.setVisible(true); //showing window
        this.masseriaID=id;
        this.home_model.addView(home_view); //adding view to model
        this.new_view(home_view); //showing view in window
        this.startHome();
    }
    
    public void new_view(JPanel jPanel)
    {
        this.baseWindow.setContentPane(jPanel);
        this.baseWindow.revalidate();
        this.baseWindow.repaint();
    }
    
    public void startHome()
    {
        this.new_view(home_view);
        this.home_model.loadAppezzamentoAndCultura(this.masseriaID);
    }
    
    public void startPlot()
    {
        new Plot_Controller();
    }
}
