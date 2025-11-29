public interface RideInterface {
    // Part3相关方法：队列操作
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part4相关方法：历史记录操作
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part5相关方法：运行一轮
    void runOneCycle();
}