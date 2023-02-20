package utils;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Tyler
 * @createDate: 2022/2/8
 */

public class DocUtil
{
    /**
     * 打印类及其字段、方法的注释
     *
     * @param sources java源文件路径
     */
    public static void println(ArrayList<String> sources)
    {
        ArrayList<String> list=new ArrayList<>();
        list.add("-doclet");
        list.add(DocUtil.class.getName());
        list.addAll(sources);
        com.sun.tools.javadoc.Main.execute(list.toArray(new String[list.size()]));
 
        StringBuilder buffer=new StringBuilder();
        ClassDoc[] classes= DocUtil.root.classes();
        for(ClassDoc classDoc:classes)
        {
            buffer.append(classDoc.name()).append('\n');
            buffer.append('\t').append(classDoc.commentText()).append('\n');
            buffer.append('\t').append("字段").append('\n');
            FieldDoc[] fields=classDoc.fields(false);
            for(FieldDoc field:fields)
            {
                buffer.append('\t').append('\t').append(field.name()).append('\n');
                buffer.append('\t').append('\t').append('\t').append(field.commentText()).append('\n');    //字段上的注释
            }
            buffer.append('\t').append("方法").append('\n');
            MethodDoc[] methods=classDoc.methods();
            for(MethodDoc method:methods)
            {
                buffer.append('\t').append('\t').append(method.name()).append('\n');
                buffer.append('\t').append('\t').append('\t').append(method.commentText()).append('\n');    //方法上的注释
            }
        }
        System.out.println(buffer);
    }

    public static Map<String,String> getDoc(ArrayList<String> sources)
    {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        list.add("-doclet");
        list.add(DocUtil.class.getName());
        list.addAll(sources);
        com.sun.tools.javadoc.Main.execute(list.toArray(new String[list.size()]));
        ClassDoc[] classes= DocUtil.root.classes();
        for(ClassDoc classDoc:classes)
        {
            FieldDoc[] fields=classDoc.fields(false);
            for(FieldDoc field:fields)
            {
                map.put(field.name(),field.commentText());
            }
        }
        return map;
    }
 
    /** 文档根节点 */
    private static RootDoc root;
 
    /**
     * javadoc调用入口
     *
     * @param root
     * @return
     */
    public static boolean start(RootDoc root)
    {
        DocUtil.root=root;
        return true;
    }
}