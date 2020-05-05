
public class MemoryAccess {

	static String ALUresult;
	static String readData1;
	static String readData2;

	static boolean controlMemRead;
	static boolean controlMemWrite;
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useMem;
	static boolean useWB;

	static String writeRegister;

	static String Address;
	static String WriteData;

	static String ReadData;

	public static void memAccess() {

		System.out.println("------------------------Performing Memory Access------------------------");
		
		Address = ALUresult;
		WriteData = readData1;
		
		if(controlMemRead){
			ReadData=DataMemory.getData(Address);
			System.out.println("Reading Data from memory no: "+ Integer.parseInt(Address, 2) +" with address: " + Address);

			System.out.println("The Data read is: " + ReadData);

		} else if (controlMemWrite) {

			System.out.println("Writing the Data: " + WriteData + " ,at memory no: " + Integer.parseInt(Address, 2)
					+ " with address: " + Address);

			DataMemory.setData(WriteData, Address);

		} else {
			System.out.println("No memory access occured");
		}

		System.out.println();

	}

}
