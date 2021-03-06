package creatorImpl;

import bean.TableInfo;
import core.DBManager;
import core.JavaCreator;
import core.TypeConvertor;
import utils.StringUtils;

/**
 * 生成Service java文件
 * @author Malcolm
 *
 */
public class JavaServiceCreator extends JavaCreator{
	
	public JavaServiceCreator(TableInfo tableInfo, TypeConvertor typeConvertor, String module, String suffix) {
		super(module, typeConvertor, suffix,tableInfo);
	}

	public JavaServiceCreator(TableInfo tableInfo, String module, String suffix) {
		super(module, suffix,tableInfo);
	}

	@Override
	public void declareateModule(TableInfo tableInfo, StringBuilder javaSrc) {
		
		javaSrc.append("@Service\n");

	}

	@Override
	public void importPackageSrcCreator(TableInfo tableInfo, StringBuilder javaSrc) {
		
		javaSrc.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		javaSrc.append("import org.springframework.stereotype.Service;\n\n");

		javaSrc.append("import com."+ DBManager.conf.getCompanyName() +".common.BaseService;\n");
		javaSrc.append("import com."+ DBManager.conf.getCompanyName() +".common.IBaseDao;\n");
		javaSrc.append("import com."+ DBManager.conf.getCompanyName() +"."+ DBManager.conf.getProjectName() +".bean."+ tableNameFirstUpper +"Bean;\n");
		javaSrc.append("import com."+ DBManager.conf.getCompanyName() +"."+ DBManager.conf.getProjectName() +".dao.I"+ tableNameFirstUpper +"Dao;\n\n");

	}

	@Override
	public void inclassSrc(TableInfo tableInfo, StringBuilder javaSrc,TypeConvertor convertor) {
		//类的开始
		javaSrc.append("public class "+tableNameFirstUpper+ moduleNameFirstUpper +" extends BaseService<"+ tableNameFirstUpper +"Bean>{\n\n");
			
		javaSrc.append("\t@Autowired\n");
		javaSrc.append("\tpublic I"+ tableNameFirstUpper +"Dao "+ StringUtils.fieldTwoWordToLower(tableNameFirstUpper) +"Dao;\n\n");
 
		javaSrc.append("\t@Override\n");
		javaSrc.append("\tpublic IBaseDao getBaseDao() {\n");
		javaSrc.append("\t\t return "+ StringUtils.fieldTwoWordToLower(tableNameFirstUpper) +"Dao;\n");
		javaSrc.append("\t}\n\n");
		
		
		//类结束
		javaSrc.append("}");
		
		
	}

	
}
