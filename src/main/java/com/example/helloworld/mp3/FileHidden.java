package com.example.helloworld.mp3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHidden {

    private final String MAPPING_NAME="mapping.txt";
    private String mRootPath;
    private List<FileNameBean> mList=new ArrayList<>();


    public FileHidden(String path){
        mRootPath=path;
    }


    public void transform() throws IOException {
        File mapping=new File(mRootPath+File.separator+MAPPING_NAME);
        if (mapping.exists()){
            System.out.println("已经转换，无需再操作");
            return;
        }
        mList.clear();

        transformFolderFiles(mRootPath);

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < mList.size(); i++) {
            FileNameBean bean=mList.get(i);
            sb.append(bean.getOriginName()).append("%==").append(bean.getReplaceName());
            if (i!=(mList.size()-1)){
                sb.append("\n");
            }
        }

        mapping.createNewFile();
        BufferedWriter bw=new BufferedWriter(new FileWriter(mapping));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public void restore() throws Exception {
        File mapping=new File(mRootPath+File.separator+MAPPING_NAME);
        if (!mapping.exists()){
            System.out.println("没有找到转换文件");
            return;
        }

        //read content
        Map<String,String> map=new HashMap<>();
        InputStreamReader ir=new InputStreamReader(new FileInputStream(mapping),"UTF-8");
        BufferedReader reader=new BufferedReader(ir);
        String temp;
        while ((temp=reader.readLine())!=null){
            temp=temp.trim();
            if (temp.isEmpty()){
                continue;
            }
            String[] sb=temp.split("%==");
            map.put(sb[1],sb[0]);
        }
        reader.close();

        restoreFolderFiles(mRootPath,map);

        mapping.delete();
    }




    private  void transformFolderFiles(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File temp : files) {
                    if (temp.isDirectory()) {
                        System.out.println("文件夹:" + temp.getAbsolutePath());
                        transformFolderFiles(temp.getAbsolutePath());
                    } else {
                        FileNameBean bean =new FileNameBean();
                        bean.setOriginName(temp.getName());
                        File newFile=new File(temp.getParent()+File.separator+System.nanoTime());
                        if (temp.renameTo(newFile)){
                            bean.setReplaceName(newFile.getName());
                            mList.add(bean);
                            System.out.println(bean.getOriginName()+"===>>"+bean.getReplaceName());
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    private  void restoreFolderFiles(String path, Map<String,String> map) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File temp : files) {
                    if (temp.isDirectory()) {
                        System.out.println("文件夹:" + temp.getAbsolutePath());
                        restoreFolderFiles(temp.getAbsolutePath(),map);
                    } else {
                        if (!map.containsKey(temp.getName())){
                            continue;
                        }
                        File newFile=new File(temp.getParent()+File.separator+map.get(temp.getName()));
                        System.out.println(temp.getName()+"===>>"+newFile.getName());
                        temp.renameTo(newFile);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

}
