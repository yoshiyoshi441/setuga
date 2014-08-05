package com.sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * クリエータークラス
 */
public class HTMLWriter {
    /**
     * ヘッダ
     */
    private final List<String> headerList;

    /**
     * ボディー
     */
    private final List<String> bodyList;

    /**
     * クリエーターメソッド
     *
     * @param builder ビルダー
     */
    private HTMLWriter(final HTMLBuilder builder) {
        this.headerList = new ArrayList<>(builder.headerList.size());
        this.bodyList = new ArrayList<>(builder.bodyList.size());

        this.headerList.addAll(builder.headerList);
        this.bodyList.addAll(builder.bodyList);
    }

    /**
     * Writeメソッド
     * writerを変えれば何でも書ける
     */
    public void write(Writer writer) throws IOException {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<html>");
        buffer.append("<head>");
        for (String element : headerList) {
            buffer.append(element);
        }
        buffer.append("</head>");
        buffer.append("<body>");
        for (String element : bodyList) {
            buffer.append(element);
        }
        buffer.append("<body>");
        buffer.append("<html>");
        writer.write(buffer.toString());
        writer.flush();
    }

    /**
     * ビルダークラス
     */
    public static class HTMLBuilder {
        /**
         * ヘッダ
         */
        private final List<String> headerList;

        /**
         * ボディー
         */
        private final List<String> bodyList;

        /**
         * コンストラクタ
         */
        public HTMLBuilder() {
            this.headerList = new ArrayList<>();
            this.bodyList = new ArrayList<>();
        }

        /**
         * ビルドメソッド
         *
         * @return HTMLCreator
         */
        public HTMLWriter build() {
            return new HTMLWriter(this);
        }

        /**
         * ヘッダーの追加
         *
         * @param header ヘッダ要素
         * @return HTMLBuilder
         */
        public HTMLBuilder addHeader(final String header) {
            this.headerList.add(header);
            return this;
        }

        /**
         * Bodyの追加
         *
         * @param body ボディの中身
         * @return HTMLBuilder
         */
        public HTMLBuilder addBody(final String body) {
            this.bodyList.add(body);
            return this;
        }
    }
}
