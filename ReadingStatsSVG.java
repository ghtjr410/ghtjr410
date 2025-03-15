import java.io.FileWriter;
import java.io.IOException;

public class ReadingStatsSVG {
    public static void main(String[] args) {
        String svgContent = """
            <svg width="350" height="170" xmlns="http://www.w3.org/2000/svg">
                <defs>
                    <linearGradient id="gradBackground" x1="0%" y1="0%" x2="100%" y2="0%">
                        <stop offset="0%" style="stop-color:#2C5364; stop-opacity:1" />
                        <stop offset="50%" style="stop-color:#203A43; stop-opacity:1" />
                        <stop offset="100%" style="stop-color:#0F2027; stop-opacity:1" />
                    </linearGradient>

                    <linearGradient id="textGrad" x1="0%" y1="0%" x2="100%" y2="100%">
                        <stop offset="0%" style="stop-color:#FFEB3B; stop-opacity:1" />
                        <stop offset="100%" style="stop-color:#FF9800; stop-opacity:1" />
                    </linearGradient>
                </defs>

                <rect width="100%" height="100%" fill="url(#gradBackground)" rx="10"/>
                
                <text x="20" y="30" font-size="14" fill="white">Computer Science: <tspan fill="url(#textGrad)">5권</tspan></text>
                <text x="20" y="50" font-size="14" fill="white">Data Structure &amp; Algorithm: <tspan fill="url(#textGrad)">4권</tspan></text>
                <text x="20" y="70" font-size="14" fill="white">Java &amp; JVM: <tspan fill="url(#textGrad)">3권</tspan></text>
                <text x="20" y="90" font-size="14" fill="white">Spring Framework: <tspan fill="url(#textGrad)">2권</tspan></text>
                <text x="20" y="110" font-size="14" fill="white">Database &amp; SQL: <tspan fill="url(#textGrad)">4권</tspan></text>
                <text x="20" y="130" font-size="14" fill="white">System Design &amp; Scalability: <tspan fill="url(#textGrad)">3권</tspan></text>
                <text x="20" y="150" font-size="14" fill="white">Infrastructure &amp; DevOps: <tspan fill="url(#textGrad)">3권</tspan></text>
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