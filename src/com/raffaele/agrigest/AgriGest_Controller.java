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

import com.raffaele.agrigest.model.Appezzamento_model;
import com.raffaele.agrigest.view.Masseria_view;
import com.raffaele.agrigest.view.BaseWindow;
import com.raffaele.agrigest.model.Masseria_model;
import com.raffaele.agrigest.view.LogIn;
import javax.swing.JPanel;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class AgriGest_Controller
{
    BaseWindow baseWindow=new BaseWindow();
    
    Masseria_model masseria_model = new Masseria_model();
    Appezzamento_model appezzamento_model=new Appezzamento_model();
    Masseria_view masseria_view=new Masseria_view(this.masseria_model,this.appezzamento_model);
    LogIn logIn=new LogIn(this.masseria_model, this);
    
    public AgriGest_Controller()
    {
        this.masseria_model.addView(logIn);
        this.masseria_model.loadAll();
        this.logIn.setVisible(true);
    }
    
    public void openMain()
    {
        this.new_view(masseria_view);
        this.baseWindow.setVisible(true);
    }
    
    public void new_view(JPanel jPanel)
    {
        baseWindow.setContentPane(jPanel);
        baseWindow.revalidate();
        baseWindow.repaint();
    }
}
