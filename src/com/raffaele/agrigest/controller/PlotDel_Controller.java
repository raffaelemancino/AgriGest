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

import com.raffaele.agrigest.AgriGest;
import com.raffaele.agrigest.model.Plot_model;
import com.raffaele.agrigest.view.PlotDel_view;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class PlotDel_Controller
{
    private Plot_model plot_model=new Plot_model();
    
    public PlotDel_Controller()
    {
        PlotDel_view plotDel_view=new PlotDel_view(this.plot_model,this);
        this.plot_model.addView(plotDel_view);
        this.plot_model.selectPlot();
        AgriGest.appController.new_view(plotDel_view);
    }
    
    public void deletePlotByName(String name)
    {
        this.plot_model.deletePlotByName(name);
        AgriGest.appController.startHome();
    }
}
