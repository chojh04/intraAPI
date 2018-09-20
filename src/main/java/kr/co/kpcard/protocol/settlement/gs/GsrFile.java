package kr.co.kpcard.protocol.settlement.gs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GsrFile {

	private static final Logger logger = LoggerFactory.getLogger(GsrFile.class);
	
	public final static int RESULT_PARSE_ERROR 			= 0;
	public final static int RESULT_PARSE_SUCESS 		= 1;
	public final static int RESULT_PARSE_FAIL_TO_HEADER = 2;
	public final static int RESULT_PARSE_FAIL_TO_DATA 	= 3;
	public final static int RESULT_PARSE_FAIL_TO_TAIL 	= 4;
	
	private GsrHeaderRecord headerRecord;
	private List<GsrDataRecord> dataRecordList;
	private GsrTailRecord tailRecord;
	
	
	public GsrFile()
	{
		this.dataRecordList = new ArrayList<>();
	}
	
	public void addDataRecord(GsrDataRecord dataRecord)
	{
		if(this.dataRecordList != null) this.dataRecordList.add(dataRecord);
	}
	
	public void resetDataRecordList()
	{
		if(dataRecordList != null) dataRecordList.clear();
	}
	
	public GsrHeaderRecord getHeaderRecord() 
	{
		return headerRecord;
	}
	
	public List<GsrDataRecord> getDataRecordList() 
	{
		return dataRecordList;
	}
	
	public GsrTailRecord getTailRecord() 
	{
		return tailRecord;
	}
	
	@SuppressWarnings("resource")
	public int parseFile(String inputFile)
	{
		int result = RESULT_PARSE_ERROR;
		
		try 
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
			
			if(!bufferedReader.ready())
			{
				logger.warn("parseFile() : bufferReader not ready | inputFile : " + inputFile );
				return result;
			}
			
			String readLine = "";
			
			while (bufferedReader.readLine() != null)
			{
				readLine = bufferedReader.readLine();
				
				String divider = readLine.substring(0, 1);
				
				
				if(GsrHeaderRecord.HEADER_DIVIDER.equals(divider))
				{
					if(this.headerRecord == null) this.headerRecord = new GsrHeaderRecord();
					if(!this.headerRecord.parse(readLine.getBytes())) return  RESULT_PARSE_FAIL_TO_HEADER;
				}
				else if(GsrDataRecord.DATA_DIVIDER.equals(divider))
				{
					if(this.dataRecordList == null) this.dataRecordList = new ArrayList<>();
					
					GsrDataRecord dataRecord = new GsrDataRecord();
					if(!dataRecord.parse(readLine.getBytes())) return RESULT_PARSE_FAIL_TO_DATA;
					else this.dataRecordList.add(dataRecord);
				}
				else if(GsrTailRecord.TAIL_DIVIDER.equals(divider))
				{
					if(this.tailRecord == null) this.tailRecord = new GsrTailRecord();
					if(!this.headerRecord.parse(readLine.getBytes())) return RESULT_PARSE_FAIL_TO_TAIL;
				}
				else
				{
					logger.warn("parseFile() : wrong divider | readLine : " + readLine );
				}
				
			}
			
			bufferedReader.close();
			
			result = RESULT_PARSE_SUCESS;
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			logger.error("exception : " + e.getMessage());
			result = RESULT_PARSE_ERROR;
		}
		
		return result;
	}
	
	public boolean makeFile(String outputFile)
	{
		boolean result = false;

		try 
		{
			if(this.headerRecord != null && this.tailRecord != null && this.dataRecordList != null) return result;
				
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
			
			bufferedWriter.write(this.headerRecord.makeRecordData());
			bufferedWriter.write("\n");
			
			for(GsrDataRecord record : this.dataRecordList)
			{
				bufferedWriter.write(record.makeRecordData());
				bufferedWriter.write("\n");
			}
			
			bufferedWriter.write(this.tailRecord.makeRecordData());
			bufferedWriter.write("\n");
			
			bufferedWriter.flush();
			bufferedWriter.close();
			
			result = true;
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			logger.error("exception : " + e.getMessage());
			result = false; 
		}
		
		return result;
	}
	
}
