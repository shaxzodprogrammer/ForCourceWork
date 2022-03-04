package com.example.coursework.utills;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CommonUtills {

    public static void validatePageNumberAndSize(int page, int size) throws IllegalAccessException {
        if (page < 0) {
            throw new IllegalAccessException("Sahifa soni noldan kam bo'lishi mumkin emas.");
        }

        if (size > com.example.coursework.utills.AppConst.MAX_PAGE_SIZE) {
            throw new IllegalAccessException("Sahifa soni " + com.example.coursework.utills.AppConst.MAX_PAGE_SIZE + " dan ko'p bo'lishi mumkin emas.");
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
