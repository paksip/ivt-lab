package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockPrimary;
  private TorpedoStore mockSecondary;

  @Before
  public void init(){
    mockPrimary = mock(TorpedoStore.class);
    mockSecondary = mock(TorpedoStore.class);
    this.ship = new GT4500(this.mockPrimary, this.mockSecondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    // mockPrimary = new TorpedoStore(1);
    when(mockPrimary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    // mockPrimary = new TorpedoStore(1);
    // mockSecondary = new TorpedoStore(1);
    when(!mockPrimary.isEmpty() && !mockSecondary.isEmpty()).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Empty_Primary() {
    // Arrange


    // Act

    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockSecondary).isEmpty();

  }
//
//  @Test
//  public void fireTorpedo_Single_Unsuccess() {
//
//
//  }
//
//  @Test
//  public void fireTorpedo_Single_Secondary_Fire_Zero_Firingrate() {
//
//
//  }


}
