/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author S2-PC113
 */
public interface DAO<E,I> {
    public int add(E entity);
    public int delete(Integer e);
    public int update(E entity);
    public ArrayList<E> findAll(E entity);
}
