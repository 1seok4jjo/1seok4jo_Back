package team.compass.search.service;

import org.springframework.stereotype.Service;
import team.compass.search.dto.SearchRequest;
import team.compass.search.dto.SearchResponse;

@Service
public interface SearchService {
    SearchResponse getSearchPostList(String pageNum, String type, String text);
}
