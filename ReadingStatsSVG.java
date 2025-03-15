import java.io.FileWriter;
import java.io.IOException;

public class ReadingStatsSVG {
    public static void main(String[] args) {
        String svgContent = """
            <svg width="350" height="170" xmlns="http://www.w3.org/2000/svg">
                <rect width="100%" height="100%" fill="#1E1E2E" rx="10"/>
                
                <text x="20" y="30" font-size="14" fill="white">⭐ Computer Science: <tspan fill="#F1C40F">5권</tspan></text>
                <text x="20" y="50" font-size="14" fill="white">📊 Data Structure &amp; Algorithm: <tspan fill="#F1C40F">4권</tspan></text>
                <text x="20" y="70" font-size="14" fill="white">☕ Java &amp; JVM: <tspan fill="#F1C40F">3권</tspan></text>
                <text x="20" y="90" font-size="14" fill="white">⚙️ Spring Framework: <tspan fill="#F1C40F">2권</tspan></text>
                <text x="20" y="110" font-size="14" fill="white">🛢 Database &amp; SQL: <tspan fill="#F1C40F">4권</tspan></text>
                <text x="20" y="130" font-size="14" fill="white">🚀 System Design &amp; Scalability: <tspan fill="#F1C40F">3권</tspan></text>
                <text x="20" y="150" font-size="14" fill="white">🌐 Infrastructure &amp; DevOps: <tspan fill="#F1C40F">3권</tspan></text>
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