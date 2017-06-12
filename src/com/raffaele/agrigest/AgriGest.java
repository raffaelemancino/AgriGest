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

import com.raffaele.agrigest.controller.AgriGest_Controller;
import com.raffaele.agrigest.database.DatabaseAccessLayer;
import com.raffaele.agrigest.model.Login_model;
import com.raffaele.agrigest.view.LogIn_view;

/**
 *
 * @author Raffaele Francesco Mancino
 * @version 0.2
 */
public class AgriGest
{
    public static DatabaseAccessLayer databaseAccessLayer=new DatabaseAccessLayer();
    public static AgriGest_Controller appController=new AgriGest_Controller();
    
    public static void main(String[] args)
    {
        login();
    }
    
    public static void login()
    {
        Login_model login_model = new Login_model();
        LogIn_view login_view=new LogIn_view(login_model);
        login_model.addView(login_view);
        login_model.loadAll();
        login_view.setVisible(true);
    }
    
    public static void startApp(int idMasseria)
    {
        appController.init(idMasseria);
    }
}
