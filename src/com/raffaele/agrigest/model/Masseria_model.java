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

import com.raffaele.agrigest.AgriGest;
import java.util.ArrayList;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class Masseria_model extends Model
{
    private ArrayList<Masseria> list;
    
    public Masseria_model()
    {
        this.nome="masseria";
    }
    public void loadAll()
    {
        this.list=AgriGest.databaseAccessLayer.selectMasseria();
        super.sendChanges();
    }
    
    public void loadByName(String nome)
    {
        this.list=AgriGest.databaseAccessLayer.selectMasseriaByName(nome);
        super.sendChanges();
    }
    
    public Masseria getMasseria(int i)
    {
        return this.list.get(i);
    }
    
    public ArrayList getList()
    {
        return this.list;
    }
}
