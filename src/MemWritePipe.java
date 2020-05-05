
public class MemWritePipe {
	static String ALUresult;
	static boolean controlRegWrite;
	static boolean controlMemtoReg;
	static boolean useWB;
	static String writeRegister;
	static String ReadData;
	
	public void getMemory() {
		this.ALUresult=MemoryAccess.ALUresult;
		this.controlRegWrite=MemoryAccess.controlRegWrite;
		this.controlMemtoReg=MemoryAccess.controlMemtoReg;
		this.useWB=MemoryAccess.useWB;
		this.writeRegister=MemoryAccess.writeRegister;
		this.ReadData=MemoryAccess.ReadData;
	}
	public void transferWrite() {
		WriteBackClass.ALUresult=this.ALUresult;
		WriteBackClass.controlRegWrite=this.controlRegWrite;
		WriteBackClass.controlMemtoReg=this.controlMemtoReg;
		WriteBackClass.useWB=this.useWB;
		WriteBackClass.writeRegister=this.writeRegister;
		WriteBackClass.ReadData=this.ReadData;
	}
	
}
