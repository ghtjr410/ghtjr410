import java.io.FileWriter;
import java.io.IOException;

public class ReadingStatsSVG {
    public static void main(String[] args) {
        String svgContent = """
            <svg width="400" height="300" xmlns="http://www.w3.org/2000/svg">
                <rect width="100%" height="100%" fill="#1E1E2E" rx="10"/>
                <text x="20" y="40" font-size="16" fill="white">📚 독서 카테고리별 통계</text>
                
                <rect x="20" y="70" width="150" height="20" fill="#FF6384" rx="5"/>
                <text x="180" y="85" font-size="14" fill="white">CS (5권)</text>
                
                <rect x="20" y="100" width="90" height="20" fill="#36A2EB" rx="5"/>
                <text x="120" y="115" font-size="14" fill="white">Language (3권)</text>
                
                <rect x="20" y="130" width="60" height="20" fill="#FFCE56" rx="5"/>
                <text x="90" y="145" font-size="14" fill="white">Framework (2권)</text>
                
                <rect x="20" y="160" width="120" height="20" fill="#4BC0C0" rx="5"/>
                <text x="150" y="175" font-size="14" fill="white">Database (4권)</text>
                
                <rect x="20" y="190" width="90" height="20" fill="#9966FF" rx="5"/>
                <text x="120" y="205" font-size="14" fill="white">Infra (3권)</text>
            </svg>
            """;

        try (FileWriter fileWriter = new FileWriter("reading_stats.svg")) {
            fileWriter.write(svgContent);
            System.out.println("✅ SVG 파일이 생성되었습니다! (reading_stats.svg)");
        } catch (IOException e) {
            System.err.println("❌ SVG 파일 생성 중 오류 발생: " + e.getMessage());
        }
    }
}