public class AdventTwo 
{
	
	public static void main(String[] args) 
	{
		// 2*l*w + 2*w*h + 2*h*l + 6 to get result
		AdventTwoInput adventInput = new AdventTwoInput();
		
		String[] inputs = adventInput.inputs;
		
		int total = 0 ;
		int totalRibbion = 0;
		
		for (int i = 0; i < inputs.length; i++) 
		{
			int result = 0;
			
			String stringDimensions = inputs[i];
			
			int[] intDimensions = getIntDimensionsFromString(stringDimensions);
			
			int length = intDimensions[0];
			int width = intDimensions[1];
			int height = intDimensions[2];
			
			int smallest = 0;
			int area1 = length * width;
			int area2 = width * height;
			int area3 = height * length;
			
			// Get the smallest area
			smallest = getSmallstArea(area1, area2, area3);
			
			// Cubic feet
			int toatalArea = ((2 *area1) + (2 * area2) + (2 * area3));
			
			// Get the result for one box
			result =  toatalArea + smallest;
			
			// Keep a running total
			total += result;
			
			// Get the parameter
			int parameter;
			
			// Get the parameter
			int largst = getLargst(length, width, height);
			parameter = (length + length) + (width + width) + (height + height);
			parameter -= (largst + largst);
			
			
			// Keep a running total of the ribbon
			totalRibbion += (length * width * height) + parameter;
		}
		
		System.out.println("The total needed to wrap the presents is: " + total);
		System.out.println("Total ribbon needed is: " + totalRibbion);
	}

	
	private static int getLargst(int length, int width, int height) 
	{
		int largest;
		
		if(length >= width)
		{
			if(length >= height)
			{
				largest = length;
			}
			else
			{
				largest = height;
			}
		}
		else if(width >= height)
		{
			largest = width;
		}
		else
		{
			largest = height;
		}
		
		return largest;
	}


	private static int getSmallstArea(int area1, int area2, int area3) 
	{
		int smallest;
		
		if(area1 <= area2)
		{
			if(area1 <= area3)
			{
				smallest = area1;
			}
			else
			{
				smallest = area3;
			}
		}
		else if(area2 <= area3)
		{
			smallest = area2;
		}
		else
		{
			smallest = area3;
		}
		
		return smallest;
	}


	private static int[] getIntDimensionsFromString(String stringDimensions) 
	{
		int[] dimensions = new int[3];
		
		// Find the first x
		int firstX = stringDimensions.indexOf('x');
		
		// Get the first number
		dimensions[0] = Integer.valueOf(stringDimensions.substring(0, firstX));
		
		// Get the second x
		int secondX = stringDimensions.indexOf("x", firstX + 1);
		
		// Get the second number
		dimensions[1] = Integer.valueOf(stringDimensions.substring(firstX + 1, secondX)); 
		
		// Get the third number
		dimensions[2] = Integer.valueOf(stringDimensions.substring(secondX + 1)); 
		
		return dimensions;
	}
}
