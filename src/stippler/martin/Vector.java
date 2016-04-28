/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stippler.martin;

/**
 *
 * @author Christian
 */
public class Vector
{
  public float x=0;
  public float y=0;

  @Override
  public String toString()
  {
    return String.format("[Vector;x:%.3f;y:%.3f]", x,y);
  }
  
  
}
