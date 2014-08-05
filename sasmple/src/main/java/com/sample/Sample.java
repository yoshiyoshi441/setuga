package com.sample;

import com.sample.HTMLWriter;

import java.io.OutputStreamWriter;

public class Sample {
    /**
     * メインメソッド
     *
     * @param args 引数
     */
    public static void main(final String[] args) throws Exception {
        HTMLWriter creator = new HTMLWriter.HTMLBuilder()
                .addHeader("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
                .addBody("<h2>こんにちわ</h2>")
                .build();

        // Writer
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        creator.write(writer);
    }
}
