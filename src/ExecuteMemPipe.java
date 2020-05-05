
public class ExecuteMemPipe {
	
	static String ALUresult;
	static String readData2;

	static boolean controlMemRead;
	static boolean controlMemWrite;
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useMem;
	static boolean useWB;
	
	static String writeRegister;


	public void getExecute() {
		this.ALUresult=ExecuteClass.ALUresult;
		this.readData2=ExecuteClass.readData2;
		
		this.controlMemRead=ExecuteClass.controlMemRead;
		this.controlMemWrite=ExecuteClass.controlMemWrite;
		this.controlRegWrite=ExecuteClass.controlRegWrite;
		this.controlMemtoReg=ExecuteClass.controlMemtoReg;
		this.useMem=ExecuteClass.useMem;
		this.useWB=ExecuteClass.useWB;
		
		this.writeRegister=ExecuteClass.writeRegister;
	}
	public void transferMem() {
		MemoryAccess.ALUresult=this.ALUresult;
		MemoryAccess.readData2=this.readData2;
		
		MemoryAccess.controlMemRead=this.controlMemRead;
		MemoryAccess.controlMemWrite=this.controlMemWrite;
		MemoryAccess.controlRegWrite=this.controlRegWrite;
		MemoryAccess.controlMemtoReg=this.controlMemtoReg;
		MemoryAccess.useMem=this.useMem;
		MemoryAccess.useWB=this.useWB;
		
		MemoryAccess.writeRegister=this.writeRegister;
	}
}
