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
package com.raffaele.agrigest;

import com.raffaele.agrigest.model.Home_model;
import com.raffaele.agrigest.view.Home_view;
import com.raffaele.agrigest.view.BaseWindow;
import com.raffaele.agrigest.model.Masseria_model;
import com.raffaele.agrigest.view.LogIn;
import javax.swing.JPanel;

/**
 *
 * @author Raffaele Francesco Mancino
 * 
 * S_methodName -> Signal get by views
 */
public class AgriGest_Controller
{
    BaseWindow baseWindow=new BaseWindow();
    
    Masseria_model masseria_model = new Masseria_model();
    Home_model home_model=new Home_model();
    
    public AgriGest_Controller()
    {
        LogIn logIn=new LogIn(this.masseria_model, this);
        Home_view home_view=new Home_view(this, this.home_model);
        
        this.masseria_model.addView(logIn);
        this.home_model.addView(home_view);
        this.masseria_model.loadAll();
        
        this.new_view(home_view);
        this.baseWindow.setVisible(true);
        logIn.setVisible(true);
    }
    
    public void new_view(JPanel jPanel)
    {
        baseWindow.setContentPane(jPanel);
        baseWindow.revalidate();
        baseWindow.repaint();
    }
    
    public void S_masseria_selected(String name)
    {
        this.masseria_model.loadByName(name);
        this.home_model.loadAppezzamentoAndCultura(this.masseria_model.getMasseria(0).id);
    }
}
