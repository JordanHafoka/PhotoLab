package pix.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;
import pixLab.classes.PictureTester;

public class FauxToeShopPanel extends JPanel
{
	private FauxToeShopController baseController;
	private JScrollPane imagePane;
	private JComboBox<String> filterBox;
	private SpringLayout baseLayout;
	private Picture basePicture;
	private String[] filters;
	private Picture newPicture;
	private JComboBox<String> pictureBox;
	
	
	public FauxToeShopPanel(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		
		filterBox = new JComboBox<String>();
		imagePane = new JScrollPane();
		pictureBox = new JComboBox<String>();
		basePicture = new Picture("DeathWing.jpg");
		newPicture = new Picture();
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, pictureBox, 0, SpringLayout.NORTH, filterBox);
		baseLayout.putConstraint(SpringLayout.EAST, pictureBox, -83, SpringLayout.WEST, filterBox);
		filters = new String[3];
		
		
	
		setupPicture();
		setupArray();
		setupPanel();
		setupLayout();
		setupListeners();
		
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		
		this.add(imagePane);
		this.add(filterBox);
		this.add(pictureBox);
		imagePane.setSize(600,800);
		
		
		this.setVisible(true);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, filterBox, 25, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, filterBox, 211, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, imagePane, 70, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, imagePane, 10, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		filterBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent arg0)
			{
				if(filterBox.getSelectedIndex()==0)
				{
					resetPicture();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 1)
				{
					resetPicture();
					basePicture.zeroBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==2)
				{
					resetPicture();
					basePicture.keepOnlyBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==3)
				{
					resetPicture();
					basePicture.keepOnlyRed();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==4)
				{
					resetPicture();
					basePicture.keepOnlyGreen();
					setupPicture();
					
				}
				else if(filterBox.getSelectedIndex()==5)
				{
					resetPicture();
					basePicture.negate();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==6)
				{
					resetPicture();
					basePicture.grayscale();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==7)
				{
					resetPicture();
					basePicture.rotateColorFilter();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==8)
				{
					resetPicture();
					basePicture.rotateColorFilter2();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==9)
				{
					resetPicture();
					basePicture.mirrorVertical();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex()==10)
				{
					resetPicture();
					basePicture.mirrorDiagonal();
					setupPicture();
				}
				
			}
			
		});
		pictureBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent arg0)
			{
				if(pictureBox.getSelectedIndex()==0)
				{
					newPicture = new Picture("DeathWing.jpg");
				}
				else if(pictureBox.getSelectedIndex()==1)
				{
					newPicture = new Picture("LoomyNarty Confirmed.jpg");
				}
				else if(pictureBox.getSelectedIndex()==2)
				{
					newPicture = new Picture("Thresh.jpg");
				}
				
			}
			
		});
	}
//	private void setupComboBox()
//	{
//		
//	}
	private void setupArray()
	{
		String [] filters = new String[11];
			
			filters[0] = "Select Filter:";
			filters[1] = "ZeroBlue";
			filters[2] = "KeepOnlyBlue";
			filters[3] = "KeepOnlyRed";
			filters[4] = "KeepOnlyGreen";
			filters[5] = "Negate";
			filters[6] = "Grayscale";
			filters[7] = "Rotate Colors";
			filters[8] = "Rotate Colors 2";
			filters[9] = "Mirror Vertical";
			filters[10]= "Mirror Diagonal";
			
		String [] pictures = new String[3];
		
			pictures[0] = "DeathWing";
			pictures[1] = "LoomyNarty Confirmed";
			pictures[2] = "Thresh";
			
	    pictureBox = new JComboBox<String>(pictures);
		filterBox = new JComboBox<String>(filters);
	}
	private void setupPicture()
	{
		BufferedImage buffPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(buffPic);
		imagePane.setViewportView(picDisplay);
	}
	private void resetPicture()
	{
		basePicture = new Picture(newPicture);
	}
}