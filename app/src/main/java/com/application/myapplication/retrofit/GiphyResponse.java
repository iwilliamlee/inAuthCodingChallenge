package com.application.myapplication.retrofit;

import java.util.List;

public class GiphyResponse {
    public class Result {
        public List<Data> data;
        public Pagination pagination;
    }

    public class Data {
        public Image images;
    }

    public class Image {
        public Original original;
    }

    public class Original {
        public String url;
    }

    public class Pagination {
        public int total_count;
        public int count;
        public int offset;
    }

}
