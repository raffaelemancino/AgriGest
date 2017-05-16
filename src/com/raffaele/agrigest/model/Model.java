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
package com.raffaele.agrigest.model;

import com.raffaele.agrigest.view.IView;
import java.util.ArrayList;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public abstract class Model {
    private ArrayList<IView> listView=new ArrayList<IView>();
    protected ArrayList list;
    protected String nome;
    
    public ArrayList getList()
    {
        return this.list;
    }
    
    public void addView(IView view)
    {
        this.listView.add(view);
    }
    
    public IView getListView(int i)
    {
        return this.listView.get(i);
    }
    
    protected void sendChanges()
    {
        for(int i=0;i<this.listView.size();i++)
        {
            this.listView.get(i).update(this.nome);
        }
    }
}
