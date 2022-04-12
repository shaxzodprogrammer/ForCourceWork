package com.example.coursework.utills;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CommonUtills {

    public static void validatePageNumberAndSize(int page, int size) throws IllegalAccessException {
        if (page < 0) {
            throw new IllegalAccessException("Pages can`t be less than 0.");
        }

        if (size > com.example.coursework.utills.AppConst.MAX_PAGE_SIZE) {
            throw new IllegalAccessException("Pages can`t be more than " + com.example.coursework.utills.AppConst.MAX_PAGE_SIZE );
        }
    }

    public static Pageable getPageableByCreatedAtDesc(int page, int size) throws IllegalAccessException {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
    }

    public static Pageable getPageableByCreatedAtAsc(int page, int size) throws IllegalAccessException {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.ASC, "createdAt");
    }

    public static Pageable getPageableByIdDesc(int page, int size) throws IllegalAccessException {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.DESC, "id");
    }

    public static Pageable getPageableByIdAsc(int page, int size) throws IllegalAccessException {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.ASC, "id");
    }

    public static Pageable simplePageable(int page, int size) throws IllegalAccessException {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size);
    }
}
