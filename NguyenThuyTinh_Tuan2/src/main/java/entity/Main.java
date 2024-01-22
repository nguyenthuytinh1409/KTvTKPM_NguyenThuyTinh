package entity;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Main {
	public static void main(String[] args) throws Exception {
//		FileInputStream in = new FileInputStream("T:\\tinh\\src\\main\\java\\entity\\Test.java");
		//PA("T:\\tinh\\src\\main\\java\\entity\\Test.java");
		System.out.println("=============");
		folder("T:\\tinh\\src\\main\\java\\entity");
		
	}

	public static void PA(String name) throws Exception {
		ParseResult<CompilationUnit> parseResult = null;
		FileInputStream in = new FileInputStream(name);
		try {
			JavaParser parser = new JavaParser();

			parseResult = parser.parse(in);
			parseResult.getProblems();
			Optional<CompilationUnit> optional = parseResult.getResult();
			if (optional.isPresent()) {
				CompilationUnit cu = optional.get();
				getFields(cu);
				System.out.println("=============");
				getMethods(cu);
				
//				System.out.println("======Cau 2=========");
//				folder("T:\\tinh\\src\\main\\java\\entity");
//
//				System.out.println("======Cau 3=========");
//				getFields(cu);

			}
		} finally {
			in.close();
		}

	}

	private static void getMethods(CompilationUnit cu) {
		// TODO Auto-generated method stub
		List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
		for (MethodDeclaration method : methods) {
			System.out.println(method.getName());
		}
	}

	private static void getFields(CompilationUnit cu) {
		// TODO Auto-generated method stub
		List<FieldDeclaration> fields = cu.findAll(FieldDeclaration.class);
		for (FieldDeclaration field : fields) {
			System.out.println(field);
		}

	}

	private static void folder (String folderName) throws Exception{
		File folder = new File(folderName);
		File [] files = folder.listFiles();
		for(File file : files) {
			
			System.out.println(file.getAbsolutePath());
			PA(file.getAbsolutePath());
		}
	}

}
