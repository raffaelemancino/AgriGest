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
import com.raffaele.agrigest.model.Login_model;
import com.raffaele.agrigest.view.LogIn_view;
import javax.swing.JPanel;

/**
 *
 * @author Raffaele Francesco Mancino
 * 
 */
public class AgriGest_Controller
{
    public int masseriaID;
    
    private BaseWindow baseWindow=new BaseWindow();
    {
        this.baseWindow.setVisible(true);
    }
    
    private Login_model login_model = new Login_model();
    private Home_model home_model=new Home_model();
    
    private LogIn_view login_view=new LogIn_view(this.login_model);
    private Home_view home_view=new Home_view(this.home_model);
    
    public AgriGest_Controller()
    {
        this.login_model.addView(login_view);
        this.home_model.addView(home_view);
        this.login_model.loadAll();
        
        this.new_view(home_view);
        login_view.setVisible(true);
    }
    
    public void S_masseria_selected(String name)
    {
        this.login_model.loadByName(name);
        this.masseriaID=this.login_model.getMasseria(0).id;
        this.home_model.loadAppezzamentoAndCultura(masseriaID);
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
