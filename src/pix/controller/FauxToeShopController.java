package pix.controller;

import pix.view.FauxToeShopFrame;
import pix.view.FauxToeShopPanel;

public class FauxToeShopController
{
	private FauxToeShopFrame appFrame;
	
	public FauxToeShopController()
	{
		appFrame = new FauxToeShopFrame(this);
	}
	
	public void start()
	{
		FauxToeShopPanel basePanel = (FauxToeShopPanel) appFrame.getContentPane();
		
		
	}
}
